
type ChipProps = {
    label : string;
    active? : boolean;
    onClick? : () => void;
};

export default function Chip ({label, active = false, onClick}: ChipProps )
{
    return(
        <button
        className = {active ? "chip chipActive" : "chip"}
        onClick={onClick}
        type = "button"
        >
            {label}
        </button>
    );
}